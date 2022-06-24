package cn.wangbing.myminisql.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个类维护了,一个平衡二叉树的结构,比如左子树和右子树,
 * 同时里面有平衡二叉树的会用到的方法,add,delete,update,find
 * 维护了表中存储的对象
 */
public class Structure implements Serializable {
    /**
     * 存放了属性map
     */
    Map<String, String> propertyMap = new HashMap<>();
    /**
     * 自增长的id
     */
    public Integer id;

    public Structure leftNode;

    public Structure rightNode;

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Structure getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Structure leftNode) {
        this.leftNode = leftNode;
    }

    public Structure getRightNode() {
        return rightNode;
    }

    public void setRightNode(Structure rightNode) {
        this.rightNode = rightNode;
    }


    //返回左子树的高度
    public int leftHeight() {
        if (leftNode == null) {
            return 0;
        }
        return leftNode.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (rightNode == null) {
            return 0;
        }
        return rightNode.height();
    }

    //返回当前结点的高度
    //递归查询高度
    public int height() {
        return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
    }

    public Structure(int id) {
        this.id = id;
    }

    //查找
    public Structure find(int id) {
        if (this.id == id) {
            return this;
        } else if (this.id > id) {
            return this.leftNode.find(id);
        } else {
            return this.rightNode.find(id);
        }
    }

    //添加结点的方法
    //递归添加
    public void add(Structure node) {
        if (node == null) {
            return;
        }
        //判断传入结点的值和当前子树的根节点的关系
        if (node.id < this.id) {
            //如果当前结点左子结点为空
            if (this.leftNode == null) {
                this.leftNode = node;
            } else {
                this.leftNode.add(node);
            }
        } else {
            //如果当前结点右子树为空
            if (this.rightNode == null) {
                this.rightNode = node;
            } else {
                this.rightNode.add(node);
            }
        }
        //为什么this是root因为在java中谁调用方法谁是this
        //当添加完一个结点后,如果:(右子树高度-左子树高度)>1,左旋转
        if (rightHeight() - leftHeight() > 1) {
            if (rightNode != null && rightNode.leftHeight() > rightNode.rightHeight()) {
                //先对当前结点的左子结点进行
                rightNode.rightRotate();
                //再对当前结点进行右旋转
                leftHeight();
            } else {
                leftRotate();
            }
            return;//必须要
        }
        if (leftHeight() - rightHeight() > 1) {
            if (leftNode != null && leftNode.rightHeight() > leftNode.leftHeight()) {
                //先对当前结点的左子结点进行
                leftNode.leftRotate();
                //再对当前结点进行右旋转
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        Map<String, String> propertyMap1 = this.getPropertyMap();
        Collection<String> values = propertyMap1.values();
        for (String string : values) {
            System.out.print(string + " ");
        }
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }

    //删除结点
    public Structure del(int id) {
        if (id == this.id) {
            return this;
        } else if (id < this.id) {//找到就是该结点
            if (this.leftNode != null) {
                return this.leftNode.del(id);
            } else {
                return null;
            }
        } else {//如果查找的值大于当前结点,向左子树找
            if (this.rightNode != null) {
                return this.rightNode.del(id);
            } else {
                return null;
            }
        }
    }

    //查找要删除结点的父节点
    public Structure searParent(int id) {
        //如果当前结点就是要删除的结点的父结点,就返回
        if ((this.leftNode != null && this.leftNode.id == id) || (this.rightNode != null && this.rightNode.id == id)) {
            return this;
        } else {
            //如果要查找的值小于当前结点的值,并且当前结点的左结点不为空
            if (id < this.id && this.leftNode != null) {
                return this.leftNode.searParent(id);
            } else if (id >= this.id && this.rightNode != null) {
                return this.rightNode.searParent(id);
            } else {
                System.out.println("没有找到父节点");
                return null;
            }
        }
    }

    //右旋转
    public void rightRotate() {
        Structure newNode = new Structure(id);
        newNode.rightNode = rightNode;
        newNode.leftNode = leftNode.rightNode;
        id = leftNode.id;
        leftNode = leftNode.leftNode;
        rightNode = newNode;
    }

    //左旋转
    public void leftRotate() {
        //创建新的结点,以当前跟结点的值
        Structure newNode = new Structure(id);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.leftNode = leftNode;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newNode.rightNode = rightNode.leftNode;
        //把当前结点的值替换成右子结点的值
        id = rightNode.id;
        //把当前结点的右子树设置成右子树的右子树
        rightNode = rightNode.rightNode;
        //把当前结点的左子节点设置成新的结点
        leftNode = newNode;
    }

}
