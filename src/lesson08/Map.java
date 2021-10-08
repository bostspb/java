package lesson08;

import lesson08.model.Enemy;
import lesson08.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.10.2021
 */

public class Map extends JPanel {

    private MainGameWindow window;

    private final int CELL_PLAYER = 1;
    private final int CELL_ENEMY = 2;
    private final int CELL_READY = 99;
    private final int CELL_EMPTY = 0;

    public static final int DIRECTION_UP = 8;
    public static final int DIRECTION_DOWN = 2;
    public static final int DIRECTION_LEFT = 4;
    public static final int DIRECTION_RIGHT = 6;

    private int[][] map;
    private int[][] invisibleMap;
    private int mapWidth;
    private int mapHeight;
    private int mapValueMin = 2;
    private int mapValueMax = 5;

    private int levelGame;

    private Player player;
    private Enemy enemy;

    private int cellWidth;
    private int cellHeight;

    private boolean isMapExist;
    private boolean isGameStart;

    Map(MainGameWindow window) {
        this.window = window;
        isMapExist = false;
        isGameStart = false;
        setBackground(Color.BLACK);
    }

    void startNewSession() {
        window.receivedLog("Start New Game");
        player = new Player("Boris");
        levelCycle();
        levelGame = 1;
        window.refreshGuiInfo(this);
        isMapExist = true;
        isGameStart = true;
    }

    private void render(Graphics g) {
        if (!isMapExist) {
            return;
        }

        paintMap(g);

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {

                if (map[y][x] == CELL_EMPTY) {
                    continue;
                }

                if (map[y][x] == CELL_PLAYER) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }

                if (map[y][x] == CELL_READY) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }

    }

    public void updatePlayer(int key) {

        if (!isMapExist) {
            return;
        }

        if (!isGameStart) {
            return;
        }

        int currentX = player.getX();
        int currentY = player.getY();

        switch (key) {
            case DIRECTION_UP:
                player.moveUp();
                break;
            case DIRECTION_LEFT:
                player.moveLeft();
                break;
            case DIRECTION_RIGHT:
                player.moveRight();
                break;
            case DIRECTION_DOWN:
                player.moveDown();
                break;
        }

        if (!isValidMovePlayer(currentX, currentY, player.getX(), player.getY())) {
            return;
        }

        playerNextMoveAction(currentX, currentY, player.getX(), player.getY());
        window.refreshGuiInfo(this);
        repaint();

        if (!player.isAlive()) {
            isGameStart = false;
            JOptionPane.showMessageDialog(this, player.getName() + " is dead");
        }

        if (!enemy.isExistEnemies()) {
            levelCycle();
        }

    }

    private void paintMap(Graphics g) {
        int meWidth = getWidth();
        int meHeight = getHeight();

        cellWidth = meWidth / mapWidth;
        cellHeight = meHeight / mapHeight;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, meWidth, y);
        }

        for (int i = 0; i <= mapWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, meHeight);
        }
    }

    private void levelCycle() {
        createMap();
        spawnPlayer();
        spawnEnemy();
        ++levelGame;
        window.receivedLog("Start level " + levelGame);
        window.refreshGuiInfo(this);
        repaint();
    }

    private void createMap() {
        mapWidth = Tools.randomValue(mapValueMin, mapValueMax);
        mapHeight = Tools.randomValue(mapValueMin, mapValueMax);
        map = new int[mapHeight][mapWidth];
        invisibleMap = new int[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = CELL_EMPTY;
                invisibleMap[y][x] = CELL_EMPTY;
            }
        }
        window.receivedLog("Create map. Size is " + mapWidth + "x" + mapHeight);
    }

    private void spawnPlayer() {
        player.setPosition(Tools.randomValue(0, mapWidth - 1), Tools.randomValue(0, mapHeight - 1));
        map[player.getY()][player.getX()] = CELL_PLAYER;
    }

    private void spawnEnemy() {
        enemy = new Enemy((mapWidth + mapHeight) / 2);

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemy.getCountEnemies(); i++) {

            do {
                enemyPosX = Tools.random.nextInt(mapWidth);
                enemyPosY = Tools.random.nextInt(mapHeight);
            } while (!isEmptyCell(map, enemyPosX, enemyPosY) || !isEmptyCell(invisibleMap, enemyPosX, enemyPosY));

            invisibleMap[enemyPosY][enemyPosX] = CELL_ENEMY;
        }

    }

    private void playerNextMoveAction(int lastPosX, int lastPosY, int nextPosX, int nextPosY) {
        if (invisibleMap[nextPosY][nextPosX] == CELL_ENEMY) {
            window.receivedLog(player.getName() + " has been attack");
            battle(nextPosX, nextPosY);
        }

        map[lastPosY][lastPosX] = CELL_READY;
        map[player.getY()][player.getX()] = CELL_PLAYER;
    }

    private void battle(int x, int y) {
        int currentEnemyHealth = enemy.getHealth();

        while (player.isAlive() && currentEnemyHealth > 0) {
            currentEnemyHealth -= player.getPower();
            if (currentEnemyHealth > 0) {
                player.decreaseHealth(enemy.getPower());
            } else {
                enemy.killEnemy();
                invisibleMap[y][x] = CELL_EMPTY;
                break;
            }
        }
    }

    private boolean isEmptyCell(int[][] mapCheck, int x, int y) {
        return mapCheck[y][x] == CELL_EMPTY;
    }

    private boolean isValidMovePlayer(int currentPosXPlayer, int currentPosYPlayer, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWidth && nextY >= 0 && nextY < mapHeight) {
            window.receivedLog(player.getName() + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success!");
            return true;
        } else {
            player.setPosition(currentPosXPlayer, currentPosYPlayer);
            window.receivedLog("Invalid move!");
            return false;
        }
    }

    public String getLevelGame() {
        return "Level: " + levelGame;
    }

    public String getMapSize() {
        return "Map Size: " + mapWidth + ":" + mapHeight;
    }

    public String getCountEnemies() {
        return "Enemies: " + enemy.getCountEnemies();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
