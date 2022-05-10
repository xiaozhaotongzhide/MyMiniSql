package cn.wangbing.myminisql.entity;

/**
 * 维护了数据库表存储结构
 */
public class TableAVLtree {
    private Structure root;

    public Structure getRoot() {
        return root;
    }

    //查找要删除的结点
    public Structure search(int id) {
        if (root == null) {
            return null;
        } else {
            return root.del(id);
        }
    }

    //查找要父节点
    public Structure searchParent(int id) {
        if (root == null) {
            return null;
        } else {
            return root.searParent(id);
        }
    }

    //删除结点
    public void deleNode(int id) {
        if (root == null) {
            return;
        } else {
            //先找到要删除的结点
            Structure targetNode = search(id);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现这棵树只有一个结点
            if (root.leftNode == null && root.rightNode == null) {
                root = null;
                return;
            }
            //找到targetNode
            Structure parent = searchParent(id);

            if (targetNode.leftNode == null && targetNode.rightNode == null) {//如果要删除的结点是叶子结点
                //判断targetNode 是父节点的左子结点
                if (parent.leftNode != null && parent.leftNode.id == id) {
                    parent.leftNode = null;
                } else if (parent.rightNode != null && parent.rightNode.id == id) {
                    parent.rightNode = null;
                }
            } else if (targetNode.leftNode != null && targetNode.rightNode != null) {//如果要删除的结点有两个子结点
                //定义一个Node让他等于targetNode.left,我们利用他找到targetNode右子树最小的
                Structure node = targetNode.rightNode;
                while (node.leftNode != null) {
                    node = targetNode.leftNode;
                }
                //这时node指向的最小
                deleNode(node.id);
                targetNode.id = node.id;
            } else {//删除只有一颗子树的结点
                if (targetNode.leftNode != null) {//如果要删除的结点有左子结点
                    if (parent != null) {
                        //如果targetNode是parent的左
                        if (parent.leftNode.id == id) {
                            parent.leftNode = targetNode.leftNode;
                        } else {//说明是右子结点
                            parent.rightNode = targetNode.leftNode;
                        }
                    } else {
                        root = targetNode.leftNode;
                    }
                } else {//如果要删除的结点是右子结点
                    if (parent != null) {
                        if (parent.leftNode.id == id) {
                            parent.leftNode = targetNode.rightNode;
                        } else {
                            parent.rightNode = targetNode.rightNode;
                        }
                    } else {
                        root = targetNode.rightNode;
                    }


                }
            }

        }
    }

    //查找方法
    public void find(int id) {
        if (root == null) {
            System.out.println("二叉排序树为空");
        } else {
            Structure node = root.find(id);
            System.out.println(node);
        }
    }

    //添加结点的方法
    public void add(Structure node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }
}
