public class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++

        //插入数据
        if(pos < 0 || pos > this.elem.length - 1){
            return;
        }else if(isFull()){
            //用Arrays.copyOf()方法扩容数组
            Arrays.copyOf(this.elem,this.elem.length * 2);

            //下面被注释的代码块是用for()循环扩容数组
//            int newCapacity = this.elem.length * 2;
//            int[] newArray = new int[newCapacity];
//            for (int i = 0; i < this.usedSize; i++) {
//                newArray[i] = this.elem[i];
//            }
//            this.elem = newArray;
        } else{
            int i;
            for (i = this.usedSize - 1; i >= pos; i--) {
                this.elem[i + 1] = this.elem[i];
            }
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.elem.length; i++) {
            if(toFind == this.elem[i]){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
        //        int left = 0;
//        int right = elem.length - 1;
//        while(left < right){
//            int mid = (left + right) / 2;
//            if(toFind < elem[mid]){
//                right = mid - 1;
//            }else if(toFind > elem[mid]){
//                left = mid + 1;
//            }else{
//                return mid;
//            }
//        }
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos > this.usedSize){
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        this.elem[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {//------------------------------------------
        //1、顺序表是否为空
        //2、查找要删除数字的下标
        //3、删除
        //查找toRemove下标
        int index = search(toRemove);
        if(index == -1){
            System.out.println("没有你要删除的数字");
            return;
        }
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }
    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i]+ " ");
        }
        System.out.println();
    }
}
