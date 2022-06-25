package org.robot;

import java.util.*;

public class MakeRobot {

    /**
     * ロボットを任意の数だけ生成して配列へ格納する関数
     * @param robotIndividual
     * @return 生成したロボット一覧
     */
    public ArrayList<Robot> makeRobot(int robotIndividual) {
        ArrayList<Robot> robotList = new ArrayList<>();

        try {
            for (int i = 0; i < robotIndividual; i++) {
                Robot robotObject = new Robot("ロボット" + i);
                robotList.add(robotObject);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return robotList;
    }

    /**
     * 任意のロボットの友達リストに追加する関数
     * @param probability 友達になれる確率（%）
     * @param robot 生成したロボット一覧
     */
    public void addFriendRobot(int probability, ArrayList<Robot> robot) {
        Random random = new Random();
        Robot robotIndex;
        Robot randomRobotIndex;

        for (int i = 0; i < robot.size(); i++) {
            // 0~100で乱数生成
            int randomProbability = random.nextInt(101);

            if (randomProbability < probability) {
                robotIndex = robot.get(i);
                randomRobotIndex = robot.get(random.nextInt(robot.size()));

                robotIndex.addFriend(randomRobotIndex);
                randomRobotIndex.addFriend(robotIndex);
            }
        }
    }
}
