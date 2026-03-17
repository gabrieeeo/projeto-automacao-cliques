package me.gabrieeeo.main;

import com.github.kwhat.jnativehook.GlobalScreen;
import me.gabrieeeo.keyboard.KeyboardController;
import me.gabrieeeo.menu.Menu;
import me.gabrieeeo.mouse.MouseController;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    final private static Timer timer = new Timer();
    private static MouseController mouseController;

    public static void main(String[] args) {

        // Iniciar 'Menu'
        Menu menu = new Menu();

        // Registrar 'NativeHook'
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            System.out.println("Error register Native Hook: " + e.getMessage());
        }
        GlobalScreen.addNativeKeyListener(new KeyboardController());

        // Inicializar 'MouseController'
        try {
            mouseController = new MouseController();
        } catch (AWTException e) {
            System.out.println("Error initialize 'MouseController':" + e.getMessage());
            return;
        }

        // Agendar tarefa para ser executada a cada 1.5 segundos
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Executar cliques em determinada posição
                try {
                    /*Point ponto = MouseInfo.getPointerInfo().getLocation();

                    int x = (int) ponto.getX();
                    int y = (int) ponto.getY();

                    System.out.println("Coordenadas: X=" + x + ", Y=" + y);*/
                    //619 630
                    //979 533
                    Thread.sleep(3000);
                    mouseController.click(619, 630);
                    Thread.sleep(500);
                    mouseController.click(980, 533);
                } catch (InterruptedException e) {
                    System.out.println("Thread error: " + e.getMessage());
                }
            }
        }, 0, 1500);
    }
}
