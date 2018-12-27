package com.example.myapp;

class Cell {

    enum State {TIC, TAC} // X,O

    State state;
    private int x;
    private int y;


    void setX(int x) {
        this.x = x;
    }


    void setY(int y) {
        this.y = y;

    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                state == cell.state;
    }

    Cell(int x, int y, State state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

}
