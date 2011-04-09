/*
 * ProtoNode.h
 *
 *  Created on: Apr 2, 2011
 *      Author: oneamtu
 */

#ifndef ProtoNode_H_
#define ProtoNode_H_

#include <QList>
#include <string>
#include <google/protobuf/message.h>
#include <google/protobuf/descriptor.h>

#include "Node.h"

namespace ProtoView {

namespace proto = google::protobuf;

class ProtoNode : public TreeModel::Node {

public:
    ProtoNode(Node* _parent,
              const proto::FieldDescriptor* _fieldDescriptor,
              const proto::Message* _message = NULL);
    virtual ~ProtoNode();

    void constructTree();
    QVariant getData(int column) const;
    int getNumColumns() const;
    QVariant getName() const;
    QVariant getValue() const;

    const proto::FieldDescriptor *getFieldDescriptor() const;
    const proto::Message *getMessage() const;

private:
    QVariant getSingleValue() const;

private:
    const static int NUM_DATA_COLUMNS = 2;

    const proto::FieldDescriptor* fieldDescriptor;
    const proto::Message* message;
};

}
#endif /* ProtoNode_H_ */
