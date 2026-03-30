package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<Car> cars = new ArrayList<>();

    //게임 실행 메인 로직
    public void run() {
        String[] carNames = inputView.getCarNames();
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }

        int attemptCount = inputView.getCount();

        outputView.printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            playRound();
            outputView.printRaceStatus(cars);
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }
}