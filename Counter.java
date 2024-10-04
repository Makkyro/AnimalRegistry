class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() {
        if (closed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        count++;
        System.out.println("Количество животных: " + count);
    }

    @Override
    public void close() {
        closed = true;
        System.out.println("Ресурс закрыт.");
    }
}