import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JFrame {

    private SnakePanel snakePanel;

    public SnakeGame() {
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        snakePanel = new SnakePanel();
        add(snakePanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }

    private static class SnakePanel extends JPanel implements ActionListener {

        private static final int WIDTH = 400;
        private static final int HEIGHT = 400;
        private static final int UNIT_SIZE = 20;
        private static final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        private static final int DELAY = 75;

        private final int[] x = new int[GAME_UNITS];
        private final int[] y = new int[GAME_UNITS];

        private int bodyParts = 6;
        private int applesEaten = 0;
        private int appleX;
        private int appleY;
        private char direction = 'R';
        private boolean running = false;
        private Timer timer;

        public SnakePanel() {
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            setBackground(Color.black);
            setFocusable(true);
            requestFocusInWindow();
            addKeyListener(new SnakeKeyListener());
            startGame();
        }

        public void startGame() {
            newApple();
            running = true;
            timer = new Timer(DELAY, this);
            timer.start();
        }

        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkApple();
                checkCollisions();
            }
            repaint();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {
            if (running) {
                for (int i = 0; i < WIDTH / UNIT_SIZE; i++) {
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, HEIGHT);
                }
                for (int i = 0; i < HEIGHT / UNIT_SIZE; i++) {
                    g.drawLine(0, i * UNIT_SIZE, WIDTH, i * UNIT_SIZE);
                }

                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(Color.green);
                    } else {
                        g.setColor(new Color(45, 180, 0));
                    }
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + applesEaten, (WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
            } else {
                gameOver(g);
            }
        }

        public void newApple() {
            appleX = (int) (Math.random() * (WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            appleY = (int) (Math.random() * (HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        }

        public void move() {
            for (int i = bodyParts; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            switch (direction) {
                case 'U':
                    y[0] -= UNIT_SIZE;
                    break;
                case 'D':
                    y[0] += UNIT_SIZE;
                    break;
                case 'L':
                    x[0] -= UNIT_SIZE;
                    break;
                case 'R':
                    x[0] += UNIT_SIZE;
                    break;
            }
        }

        public void checkApple() {
            if (x[0] == appleX && y[0] == appleY) {
                bodyParts++;
                applesEaten++;
                newApple();
            }
        }

        public void checkCollisions() {
            // Check if the head collides with the body
            for (int i = bodyParts; i > 0; i--) {
                if (x[0] == x[i] && y[0] == y[i]) {
                    running = false;
                    break;
                }
            }

            // Check if the head collides with the borders
            if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT) {
                running = false;
            }

            if (!running) {
                timer.stop();
            }
        }

        public void gameOver(Graphics g) {
            g.setColor(Color.red);
            g.setFont(new Font("times new roman", Font.BOLD, 40));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("Better luck next time", (WIDTH - metrics1.stringWidth("Better luck next time")) / 2, HEIGHT / 2);

            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            FontMetrics metrics2 = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (WIDTH - metrics2.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        }

        private class SnakeKeyListener extends KeyAdapter {

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 'D') {
                            direction = 'U';
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'U') {
                            direction = 'D';
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 'R') {
                            direction = 'L';
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'L') {
                            direction = 'R';
                        }
                        break;
                }
            }
        }
    }
}
