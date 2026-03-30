package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        validateCarNames(names);
        return names;
    }

    public int getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine(); //처음부터 int로 받는 것보다 String으로 받고 int로 바꾸는게 더 정확함
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }


    private void validateCarNames(String[] names) {
        List<String> nameList = new ArrayList<>();

        for (String name : names) {
            // 공백이 들어있는지 확인
            if(name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
            // 이름이 비어있는지 확인
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
            }
            // 5자가 넘는지 확인
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            // 이미 나온 이름인지 확인 (중복 체크)
            if (nameList.contains(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }

            nameList.add(name); // 검사를 통과한 이름은 리스트에 보관
        }
    }
}