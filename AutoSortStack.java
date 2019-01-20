import java.util.Stack;

/* 1. Pop all element from the stack by recursion
*  2. Add element back to stack
*         a. if stack is empty -> add ele directly
*         b. stack is not empty -> pop one element out and compare
*         c. if new element is bigger append to the end.
*         d. if new element is smaller keep recursion.
*/

public class AutoSortStack {
    private Stack<Integer> s;

    private Stack<Integer> sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            addStack(stack,x);
        }
        return stack;
    }

    private void addStack(Stack<Integer> stack, int x){
        if(stack.isEmpty())
             stack.add(x);
        else {
             int y = stack.pop();
             if(x < y){
                  addStack(stack, x);
                  stack.add(y);
             }
             else{
                  stack.add(y);
                  stack.add(x);
             }
        }
    }

    public String toString(){
        return s.toString();
    }

    public AutoSortStack(Stack<Integer> s){
        this.s = sortStack(s);
    }
}
