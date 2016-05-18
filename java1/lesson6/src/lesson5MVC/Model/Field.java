package lesson5MVC.Model;

/**
 * Created by Steve on 10.05.2016.
 */
public class Field {

    public static final int MAX_CELLS_X = 3;
    public static final int MAX_CELLS_Y = 3;

    public enum Type {X, O, NOT_SET}
//    enum int {0, 1, 2, 3, 4} // метафора

    Type[][] cells;

    public Field(Type[][] cells) {
        this.cells = cells;
    }

    public Field() {
        cells = new Type[MAX_CELLS_X][MAX_CELLS_Y];
        for (int i = 0; i < MAX_CELLS_X; i++) {
            for (int j = 0; j < MAX_CELLS_Y; j++) {
                cells[i][j] = Type.NOT_SET;
            }
        }
    }

    public void show() {
        for (int i = 0; i < MAX_CELLS_X; i++) {
            for (int j = 0; j < MAX_CELLS_Y; j++) {
                switch (cells[i][j]) {
                    case X:
                        System.out.print("X");
                        break;
                    case O:
                        System.out.print("O");
                        break;
                    case NOT_SET:
                        System.out.print(".");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void doShoot(Point point, Type type) {
        //todo проверка
        if (cells[point.getX()][point.getY()] == Type.NOT_SET) {
            cells[point.getX()][point.getY()] = type;
        }
    }

    public boolean checkWin(Type t) {
        boolean isWin = false;

        // Левая диагональ
        if (cells[0][0] == t && cells[1][1] == t && cells[2][2] == t) {
            isWin = true;
        }

        // Правая диагональ
        if (cells[0][2] == t && cells[1][1] == t && cells[2][0] == t) {
            isWin = true;
        }

        // Первая горизонталь
        if (cells[0][0] == t && cells[0][1] == t && cells[0][2] == t) {
            isWin = true;
        }

        // Вторая горизонталь
        if (cells[1][0] == t && cells[1][1] == t && cells[1][2] == t) {
            isWin = true;
        }

        // Третья горизонталь
        if (cells[2][0] == t && cells[2][1] == t && cells[2][2] == t) {
            isWin = true;
        }

        // Первая вертикаль
        if (cells[0][0] == t && cells[1][0] == t && cells[2][0] == t) {
            isWin = true;
        }

        // Вторая вертикаль
        if (cells[0][1] == t && cells[1][1] == t && cells[2][1] == t) {
            isWin = true;
        }

        // Третья вертикаль
        if (cells[0][2] == t && cells[1][2] == t && cells[2][2] == t) {
            isWin = true;
        }
        return isWin;
    }
}
