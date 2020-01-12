package Polymorphism.calculator;

import java.util.Deque;

public class MemoryRecall implements Operation {
    private Deque<Integer> memory;

    public MemoryRecall(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
