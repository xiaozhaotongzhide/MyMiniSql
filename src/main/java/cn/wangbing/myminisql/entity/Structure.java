package cn.wangbing.myminisql.entity;

/**
 * 这个类维护了,一个平衡二叉树的结构,比如左子树和右子树,
 * 同时里面有平衡二叉树的会用到的方法,add,delete,update,find
 */
public class Structure {

    /**
     * 自增长的id
     */
    public Integer id;

    public Structure leftNode;

    public Structure rightNode;

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

    /**
     * 增
     *
     * @param item
     */
    public void add(Structure item) {

    }

    /**
     * 删
     *
     * @param id
     */
    public void delete(Integer id) {

    }

    /**
     * 改
     * @param item
     */
    public void update(Structure item) {

    }

    /**
     * 查
     * @param id
     * @return
     */
    public Structure find(Integer id){
        return null;
    }
}
