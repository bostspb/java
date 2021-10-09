package lesson08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 07.10.2021
 */

public class GuiPanel extends JPanel {

    private MainGameWindow window;

    private JPanel gameControlArea;
    private JButton buttonStartGame;
    private JButton buttonExitGame;

    private JPanel gameInfoArea;
    private JLabel gameLevelInfo;
    private JLabel gameMapSizeInfo;
    private JLabel gameEnemyCountInfo;

    private JPanel playerInfoArea;
    private JLabel playerHealthInfo;
    private JLabel playerStrInfo;
    private JLabel playerPositionInfo;

    private JPanel playerControllerArea;
    private JButton playerMoveUp;
    private JButton playerMoveLeft;
    private JButton playerMoveRight;
    private JButton playerMoveDown;

    private JScrollPane scrollPanel;
    private JTextArea gameLog;

    GuiPanel(MainGameWindow window) {
        this.window = window;
        setLayout(new GridLayout(5, 1));

        setupGameControl();
        setupGameInfo();
        setupPlayerInfo();
        setupPlayerController();
        setupGameLog();

        addAllArea();
    }

    private void addAllArea() {
        add(gameControlArea);
        add(gameInfoArea);
        add(playerInfoArea);
        add(playerControllerArea);
        add(scrollPanel);
    }

    void refreshInfoAreas(Map map) {
        gameLevelInfo.setText(map.getLevelGame());
        gameMapSizeInfo.setText(map.getMapSize());
        gameEnemyCountInfo.setText(map.getCountEnemies());
        playerHealthInfo.setText("Health: " + map.getPlayer().getHealth());
        playerStrInfo.setText("Power: " + map.getPlayer().getPower());
        playerPositionInfo.setText("Position: " + map.getPlayer().getPosition());

    }

    private void setupGameControl() {
        gameControlArea = new JPanel();
        gameControlArea.setLayout(new GridLayout(3, 1));

        buttonStartGame = new JButton("<html><u>Start Game!</u></html>");
        buttonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.setText("");
                window.startNewGame();
            }
        });

        buttonExitGame = new JButton("Exit Game!");
        buttonExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(999);
            }
        });

        gameControlArea.add(new JLabel("=Game Menu="));
        gameControlArea.add(buttonStartGame);
        gameControlArea.add(buttonExitGame);
    }

    private void setupGameInfo() {
        gameInfoArea = new JPanel();
        gameInfoArea.setLayout(new GridLayout(4, 1));

        gameLevelInfo = new JLabel("Level: -");
        gameMapSizeInfo = new JLabel("Map Size: -:-");
        gameEnemyCountInfo = new JLabel("Enemies: -");

        gameInfoArea.add(new JLabel("=Game Info="));
        gameInfoArea.add(gameLevelInfo);
        gameInfoArea.add(gameMapSizeInfo);
        gameInfoArea.add(gameEnemyCountInfo);
    }

    private void setupPlayerInfo() {
        playerInfoArea = new JPanel();
        playerInfoArea.setLayout(new GridLayout(4, 1));
        playerHealthInfo = new JLabel("Health: -");
        playerStrInfo = new JLabel("Power: -");
        playerPositionInfo = new JLabel("Position: -:-");

        playerInfoArea.add(new JLabel("=Player Info="));
        playerInfoArea.add(playerHealthInfo);
        playerInfoArea.add(playerStrInfo);
        playerInfoArea.add(playerPositionInfo);
    }

    private void setupPlayerController() {
        playerControllerArea = new JPanel();
        playerControllerArea.setLayout(new GridLayout(1, 4));

        playerMoveUp = new JButton("\uD83E\uDC45");
        playerMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.changePositionPlayer(Map.DIRECTION_UP);
            }
        });


        playerMoveLeft = new JButton("\uD83E\uDC44");
        playerMoveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.changePositionPlayer(Map.DIRECTION_LEFT);
            }
        });


        playerMoveRight = new JButton("\uD83E\uDC46");
        playerMoveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.changePositionPlayer(Map.DIRECTION_RIGHT);
            }
        });


        playerMoveDown = new JButton("\uD83E\uDC47");
        playerMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.changePositionPlayer(Map.DIRECTION_DOWN);
            }
        });


        playerControllerArea.add(playerMoveLeft);
        playerControllerArea.add(playerMoveUp);
        playerControllerArea.add(playerMoveDown);
        playerControllerArea.add(playerMoveRight);

    }

    private void setupGameLog() {
        gameLog = new JTextArea();
        gameLog.setLineWrap(true);
        gameLog.setEditable(false);
        scrollPanel = new JScrollPane(gameLog);
    }

    void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

}
