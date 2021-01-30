package com.sgg.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression ="3+2*6-2";
        //创建俩个栈 数栈  符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0; //用于扫描
        int num1 = 0;
        int num2 = 0;
        char oper = ' ';
        int res = 0;
        char ch = ' ';   //将每次扫描到char保存到ch
        //开始while循环扫描 expression
        while (true){
            //依次得到expression的一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么然后
            if (operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    if (operStack.priority(ch)<=operStack.priority(operStack.peek()));
                }else {
                    operStack.push(ch);
                }

            }
        }

    }

}
//定义一个ArrayStack 表示栈 需要扩展功能
class ArrayStack2 {
    private int maxSize;    //栈的大小
    private int[] stack;    //数组，数组模拟栈
    private int top = -1;   //top表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //返回当前栈的值，但是不是真正的pop
    public int peek(){
        return stack[top];
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈- push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈- pop
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况 (遍历栈)
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据");
            return;
        }
        //
        int i = top;
        while (true) {
            if (i < 0) {
                break;
            }
            int value = stack[i];

            System.out.println(value);
            i--;
        }
    }
    //返回运算符的优先级，优先级是程序员来确定 ，优先级使用数字表示
    //数字越大 优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else
        {
            return -1;  //假定目前的表达式只有 + - * /
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' ||  val == '*' ||val == '/';
    }
    //计算方法
    public int cal(int num1,int num2 ,char oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1+ num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }
}