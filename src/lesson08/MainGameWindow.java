package lesson08;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.10.2021
 */

public class MainGameWindow extends JFrame {

    private int windowWidth = 1024;
    private int windowHeight = 768;
    private int windowPositionX = 300;
    private int windowPositionY = 100;

    private Map gameMap;
    private GuiPanel gui;

    MainGameWindow() {
        setupWindow();
        gameMap = new Map(this);
        gui = new GuiPanel(this);
        add(gui, BorderLayout.EAST);
        add(gameMap);
        setVisible(true);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(windowPositionX, windowPositionY);
        setSize(windowWidth, windowHeight);
        setTitle("GUI Application");
        setResizable(false);
    }

    public void receivedLog(String msg) {
        gui.recordLog(msg);
    }

    void startNewGame(){
        gameMap.startNewSession();
    }

    void refreshGuiInfo(Map map) {
        gui.refreshInfoAreas(map);
    }

    void changePositionPlayer(int key) {
        gameMap.updatePlayer(key);
    }


}
