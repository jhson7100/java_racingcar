package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        return names;
    }

    private void validateCarNames(String[] names) {
        List<String> nameList = new ArrayList<>();

        for (String name : names) {
            // 공백이 들어있는지 확인
            if(name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
            }

            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if (nameList.contains(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }

            nameList.add(name);
        }
    }
}