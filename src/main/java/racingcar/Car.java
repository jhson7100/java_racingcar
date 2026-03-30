package racingcar;

public class Car {
    String name;
    int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) position++;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public int setPosition(int position) {
        return this.position = position;
    }
}