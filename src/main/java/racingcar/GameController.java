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

        List<String> winners = findWinners();
        outputView.printFinalWinners(winners);
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private List<String> findWinners() {
        // 가장 멀리 간 자동차의 위치 확인
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        //위에서 찾은 최고 기록과 똑같은 위치에 있는 자동차 이름을 다 모음.
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}