package nbtool.gui.utilitypanes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nbtool.gui.field.*;
import nbtool.data.Log;
import nbtool.data.TeamBroadcast;
import nbtool.io.BroadcastIO;
import nbtool.io.BroadcastIO.TeamBroadcastInstance;
import nbtool.io.BroadcastIO.TeamBroadcastListener;
import nbtool.io.CommonIO.IOInstance;
import nbtool.util.Logger;

public class WorldViewUtility extends UtilityParent {
	
	private class WorldView extends JFrame implements TeamBroadcastListener, ActionListener, ComponentListener
	{
		private TeamBroadcastInstance broadcastListener = null;
		
		@Override
		public void componentResized(ComponentEvent e) {}

		@Override
		public void componentMoved(ComponentEvent e) {}

		@Override
		public void componentShown(ComponentEvent e) {
			if (broadcastListener != null) {
				return;
			} else {
				Logger.println("WorldView creating broadcast listener...");
				broadcastListener = BroadcastIO.createTBI(this);
			}
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			if (broadcastListener == null) {
				return;
			} else {
				Logger.println("WorldView stopping broadcast listener...");
				broadcastListener.kill();
				broadcastListener = null;
			}
		}
		
		protected WorldView() {
			super();
			
			addComponentListener(this);

			this.setTitle("WorldView");
			//default, usually overridden later.
			this.setSize((int) FieldConstants.FIELD_WIDTH + 150, (int) FieldConstants.FIELD_HEIGHT + 50);
			this.getContentPane().setLayout(new BorderLayout());
			
			initiateTools();
			initiateFieldAndPlayers();
			
		}

		@Override
		public void ioFinished(IOInstance instance) {
			// listener died for some reason.
		}

		@Override	//TBI should be smart enough to use acceptTeamBroadcast() instead.
		public void ioReceived(IOInstance inst, int ret, Log... out) {
			Logger.println("??? recvd...");
		}

		@Override
		public boolean ioMayRespondOnCenterThread(IOInstance inst) {
			return false;
		}

		@Override
		public void acceptTeamBroadcast(TeamBroadcast tb) {
			//use tb
			Logger.printf("got from {%s:%s}", tb.robotName, tb.robotIp);
			//Logger.printf("header: %s", tb.message.header);
			Logger.printf("Team: %s, Player: %s",tb.dataTeamPacket.getTeamNumber(), tb.dataTeamPacket.getPlayerNumber());
			for (String s : tb.message.errors) {
				Logger.printf("\t%s", s);
			}
			
			if(runWorldview) {
				if(tb.dataTeamPacket.getTeamNumber() == teamNumber) {
					int index = tb.dataTeamPacket.getPlayerNumber() - 1;
					if (index >= 0 && index < robots.length) {
						if(tb.dataWorldModel.getActive()) {
							robots[tb.dataTeamPacket.getPlayerNumber()-1] = new NaoRobot();
							robots[tb.dataTeamPacket.getPlayerNumber()-1].wvNao(tb);
						} else {
							robots[tb.dataTeamPacket.getPlayerNumber()-1] = null;
						}
						/* shared ball off for now
						if(index == 3 || index == 4) {
							robots[tb.dataTeamPacket.getPlayerNumber()-1].wvSharedBall(tb);
						} */
						updateTeamInfo(tb);
						fieldDisplay.repaint();
					} else {
						Logger.warnf("WorldView got packet from correct team with OOB player: %d", 
								tb.dataTeamPacket.getPlayerNumber());
					}
				}
			}
		}
		
		private void initiateFieldAndPlayers() {
			fieldDisplay = new JPanel() {
				@Override
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					Graphics2D g2 = (Graphics2D) g;
					f.drawField(g2, shouldFlip,lineColors);
					for(int i=0; i<robots.length; i++) {
						if(robots[i] != null) {
							robots[i].drawNaoWV(g2, shouldFlip);	
						}
					}
				}
			};
			
			this.getContentPane().add(fieldDisplay, BorderLayout.CENTER);
		}
		
		private void initiateTools() {
			
			accessories = new JPanel();
			accessories.setLayout(new BoxLayout(accessories, BoxLayout.PAGE_AXIS));
			
			flip = new JButton("flip");
			flip.addActionListener(this);
			flip.setAlignmentX(Component.LEFT_ALIGNMENT);
			flip.setEnabled(true);
			accessories.add(flip);
			
			teamNumberInput = new JTextField("0",2);
			teamNumberInput.setMaximumSize(new Dimension(Short.MAX_VALUE, teamNumberInput.getPreferredSize().height));
			teamNumberInput.setAlignmentX(Component.LEFT_ALIGNMENT);

			accessories.add(teamNumberInput);
			
			startWorldView = new JButton("Start WorldView");
			startWorldView.addActionListener(this);
			startWorldView.setAlignmentX(Component.LEFT_ALIGNMENT);
			accessories.add(startWorldView);
			
			JLabel robotStates = new JLabel("Robot States");
			robotStates.setFont(new Font("Verdana", Font.BOLD, 16));
			robotStates.setAlignmentX(Component.LEFT_ALIGNMENT);
			accessories.add(robotStates);
			
			for(int i=0; i<5; i++) {
				if(playerRoles[i] == null) { playerRoles[i] = "Inactive";}
				teamInfo[i] = new JLabel("Player "+(i+1)+": "+playerRoles[i]);
				teamInfo[i].setAlignmentX(Component.LEFT_ALIGNMENT);
				accessories.add(teamInfo[i]);
			}
			
			//accessories.add(Box.createHorizontalStrut(200));
			accessories.add(Box.createVerticalGlue());

			this.getContentPane().add(accessories, BorderLayout.EAST);
		}
		
		private void updateTeamInfo(TeamBroadcast tb) {
			int playerNum = tb.dataTeamPacket.getPlayerNumber();
			if(!tb.dataWorldModel.getActive()) {
				teamInfo[playerNum-1].setText("Player "+(playerNum)+": Penalized");
			}
			
			switch (playerNum) {
				case 1:playerRoles[playerNum-1] = "Goalie";
					break;
				case 2:playerRoles[playerNum-1] = "Defender #1";
					break;
				case 3:playerRoles[playerNum-1] = "Defender #2";
					break;
				case 4:playerRoles[playerNum-1] = "Chaser #1";
					break;
				case 5:playerRoles[playerNum-1] = "Chaser #2";
					break;
			}
			teamInfo[playerNum-1].setText("Player "+(playerNum)+": "+playerRoles[playerNum-1]);
		}
		
		JPanel fieldDisplay;
		Field f = new Field();
		NaoRobot robots[] = new NaoRobot[5];
		
		JPanel accessories;
		private JButton flip;
		private JButton startWorldView;
		private JTextField teamNumberInput;
		private JLabel teamInfo[] = new JLabel[5];
		private String playerRoles[] = new String[5];
		
		private boolean shouldFlip = false;
		private boolean lineColors = false;
		private boolean runWorldview = false;
		private int teamNumber;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == flip) {
				if(shouldFlip) {
					shouldFlip = false;
					flip.setText("flip");
				} else {
					shouldFlip = true;
					flip.setText("unflip");
				}
			}
			if(e.getActionCommand() == "Start WorldView") {
				runWorldview = true;
				if(teamNumberInput.getText() != null) {
					try {
						teamNumber = Integer.parseInt(teamNumberInput.getText());
						startWorldView.setText("Stop");
						Logger.infof("Now listening to team %s", teamNumber);
					} catch(NumberFormatException E) {
						E.printStackTrace();
					}
				}
			} else if(e.getActionCommand() == "Stop") {
				runWorldview = false;
				startWorldView.setText("Start WorldView");
				Logger.infof("Stopped Listening to team %s", teamNumber);
				for(int i=0; i<robots.length; i++) {
					robots[i] = null;
					teamInfo[i].setText("Player "+(i+1)+": Inactive");
				}
			}
		}
	}

	private WorldView display = null;
	@Override
	public JFrame supplyDisplay() {
		return (display != null) ? display : (display = new WorldView());
	}

	@Override
	public String purpose() {
		return "Listen to and display broadcast messages.";
	}

	@Override
	public char preferredMemnonic() {
		return 'w';
	}
}
