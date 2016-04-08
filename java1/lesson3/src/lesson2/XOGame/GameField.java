package lesson2.XOGame;

/**
 * Created by Steve on 02.04.2016.
 */
public class GameField {
    public static final int SIZE = 3;
    public static char[][] field = new char[SIZE][SIZE];
    public static int charDotCheck = 0;

    public void paintFirstTime() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '.';
            }
        }
    }

    public void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void shoot(int shootX, int shootY) {
        field[shootX][shootY] = 'X';
    }

    public void shootComp(int shootX2, int shootY2) {
        field[shootX2][shootY2] = 'O';
    }

    public boolean isNotEnd() {
        // Горизонтальные линии
        if (field[0][0] == 'X' & field[0][1] == 'X' & field[0][2] == 'X') {
            return false;
        }
        if (field[1][0] == 'X' & field[1][1] == 'X' & field[1][2] == 'X') {
            return false;
        }
        if (field[2][0] == 'X' & field[2][1] == 'X' & field[2][2] == 'X') {
            return false;
        }
        // Вертикальные линии
        if (field[0][0] == 'X' & field[1][0] == 'X' & field[2][0] == 'X') {
            return false;
        }
        if (field[0][1] == 'X' & field[1][1] == 'X' & field[2][1] == 'X') {
            return false;
        }
        if (field[0][2] == 'X' & field[1][2] == 'X' & field[2][2] == 'X') {
            return false;
        }
        // Диагональные линии
        if (field[0][0] == 'X' & field[1][1] == 'X' & field[2][2] == 'X') {
            return false;
        }
        if (field[0][2] == 'X' & field[1][1] == 'X' & field[2][0] == 'X') {
            return false;
        }
        charDotCheck = 0;
        for (char[] row : field) {
            for (char c : row) {
                if (c == '.') {
                    charDotCheck++;
                }
            }
        }
        if (charDotCheck == 1) {
            return false;
        }
        return true;
    }

    public void shootOfComp() {
        switch (Game.shootX) {
            case 0:
                if ((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == '.')) {
                    Game.shootX2 = 0;
                    Game.shootY2 = 2;
                } else {
                    if ((field[0][0] == 'X') && (field[0][2] == 'X') && (field[0][1] == '.')) {
                        Game.shootX2 = 0;
                        Game.shootY2 = 1;
                    } else {
                        if ((field[0][1] == 'X') && (field[0][2] == 'X') && (field[0][0] == '.')) {
                            Game.shootX2 = 0;
                            Game.shootY2 = 0;
                        } else {
                            if ((field[0][0] == 'X') && (field[0][1] == '.') && (field[0][2] == '.')) {
                                Game.shootX2 = 0;
                                Game.shootY2 = 1;
                            } else {
                                if ((field[0][1] == 'X') && (field[0][0] == '.') && (field[0][2] == '.')) {
                                    Game.shootX2 = 0;
                                    Game.shootY2 = 2;
                                } else {
                                    if ((field[0][2] == 'X') && (field[0][0] == '.') && (field[0][1] == '.')) {
                                        Game.shootX2 = 0;
                                        Game.shootY2 = 1;
                                    } else {
                                        if ((field[0][0] != '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                            Game.shootX2 = 0;
                                            Game.shootY2 = 2;
                                        } else {
                                            if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                Game.shootX2 = 0;
                                                Game.shootY2 = 1;
                                            } else {
                                                if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] != '.')) {
                                                    Game.shootX2 = 0;
                                                    Game.shootY2 = 0;
                                                } else {
                                                    if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] == '.')) {
                                                        Game.shootX2 = 0;
                                                        Game.shootY2 = 2;
                                                    } else {
                                                        if ((field[0][0] == '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                            Game.shootX2 = 0;
                                                            Game.shootY2 = 1;
                                                        } else {
                                                            if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                                                Game.shootX2 = 0;
                                                                Game.shootY2 = 0;
                                                            } else {
                                                                if ((field[0][2] != '.') && (field[0][1] != '.') && (field[0][2] != '.')) {
                                                                    if ((field[1][0] != '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                                        if ((field[2][0] != '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                                                            Game.shootX2 = 2;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                                                Game.shootX2 = 2;
                                                                                Game.shootY2 = 1;
                                                                            } else {
                                                                                if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] != '.')) {
                                                                                    Game.shootX2 = 2;
                                                                                    Game.shootY2 = 0;
                                                                                } else {
                                                                                    if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] == '.')) {
                                                                                        Game.shootX2 = 2;
                                                                                        Game.shootY2 = 2;
                                                                                    } else {
                                                                                        if ((field[2][0] == '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                                                            Game.shootX2 = 2;
                                                                                            Game.shootY2 = 0;
                                                                                        } else {
                                                                                            if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                                                                                Game.shootX2 = 2;
                                                                                                Game.shootY2 = 1;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if ((field[1][0] != '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                                                            Game.shootX2 = 1;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                                                Game.shootX2 = 1;
                                                                                Game.shootY2 = 0;
                                                                            } else {
                                                                                if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                                                    Game.shootX2 = 1;
                                                                                    Game.shootY2 = 1;
                                                                                } else {
                                                                                    if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] == '.')) {
                                                                                        Game.shootX2 = 1;
                                                                                        Game.shootY2 = 0;
                                                                                    } else {
                                                                                        if ((field[1][0] == '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                                                            Game.shootX2 = 1;
                                                                                            Game.shootY2 = 1;
                                                                                        } else {
                                                                                            if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                                                                                Game.shootX2 = 1;
                                                                                                Game.shootY2 = 2;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                if ((field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == '.')) {
                    Game.shootX2 = 1;
                    Game.shootY2 = 2;
                } else {
                    if ((field[1][0] == 'X') && (field[1][2] == 'X') && (field[1][1] == '.')) {
                        Game.shootX2 = 1;
                        Game.shootY2 = 1;
                    } else {
                        if ((field[1][1] == 'X') && (field[1][2] == 'X') && (field[1][0] == '.')) {
                            Game.shootX2 = 1;
                            Game.shootY2 = 0;
                        } else {
                            if ((field[1][0] == 'X') && (field[1][1] == '.') && (field[1][2] == '.')) {
                                Game.shootX2 = 1;
                                Game.shootY2 = 1;
                            } else {
                                if ((field[1][1] == 'X') && (field[1][0] == '.') && (field[1][2] == '.')) {
                                    Game.shootX2 = 1;
                                    Game.shootY2 = 2;
                                } else {
                                    if ((field[1][2] == 'X') && (field[1][0] == '.') && (field[1][1] == '.')) {
                                        Game.shootX2 = 1;
                                        Game.shootY2 = 1;
                                    } else {
                                        if ((field[1][0] != '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                            Game.shootX2 = 1;
                                            Game.shootY2 = 2;
                                        } else {
                                            if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                Game.shootX2 = 1;
                                                Game.shootY2 = 1;
                                            } else {
                                                if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                    Game.shootX2 = 1;
                                                    Game.shootY2 = 0;
                                                } else {
                                                    if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] == '.')) {
                                                        Game.shootX2 = 1;
                                                        Game.shootY2 = 2;
                                                    } else {
                                                        if ((field[1][0] == '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                            Game.shootX2 = 1;
                                                            Game.shootY2 = 1;
                                                        } else {
                                                            if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                                                Game.shootX2 = 1;
                                                                Game.shootY2 = 0;
                                                            } else {
                                                                if ((field[1][2] != '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                                    if ((field[0][0] != '.') && (field[0][1] != '.') && (field[0][2] != '.')) {
                                                                        if ((field[2][0] != '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                                                            Game.shootX2 = 2;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                                                Game.shootX2 = 2;
                                                                                Game.shootY2 = 1;
                                                                            } else {
                                                                                if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] != '.')) {
                                                                                    Game.shootX2 = 2;
                                                                                    Game.shootY2 = 0;
                                                                                } else {
                                                                                    if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] == '.')) {
                                                                                        Game.shootX2 = 2;
                                                                                        Game.shootY2 = 2;
                                                                                    } else {
                                                                                        if ((field[2][0] == '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                                                            Game.shootX2 = 2;
                                                                                            Game.shootY2 = 0;
                                                                                        } else {
                                                                                            if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                                                                                Game.shootX2 = 2;
                                                                                                Game.shootY2 = 1;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if ((field[0][0] != '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                                                            Game.shootX2 = 0;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] != '.')) {
                                                                                Game.shootX2 = 0;
                                                                                Game.shootY2 = 0;
                                                                            } else {
                                                                                if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                                                    Game.shootX2 = 0;
                                                                                    Game.shootY2 = 1;
                                                                                } else {
                                                                                    if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] == '.')) {
                                                                                        Game.shootX2 = 0;
                                                                                        Game.shootY2 = 0;
                                                                                    } else {
                                                                                        if ((field[0][0] == '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                                                            Game.shootX2 = 0;
                                                                                            Game.shootY2 = 1;
                                                                                        } else {
                                                                                            if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                                                                                Game.shootX2 = 0;
                                                                                                Game.shootY2 = 2;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                if ((field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == '.')) {
                    Game.shootX2 = 2;
                    Game.shootY2 = 2;
                } else {
                    if ((field[2][0] == 'X') && (field[2][2] == 'X') && (field[2][1] == '.')) {
                        Game.shootX2 = 2;
                        Game.shootY2 = 1;
                    } else {
                        if ((field[2][1] == 'X') && (field[2][2] == 'X') && (field[2][0] == '.')) {
                            Game.shootX2 = 2;
                            Game.shootY2 = 0;
                        } else {
                            if ((field[2][0] == 'X') && (field[2][1] == '.') && (field[2][2] == '.')) {
                                Game.shootX2 = 2;
                                Game.shootY2 = 1;
                            } else {
                                if ((field[2][1] == 'X') && (field[2][0] == '.') && (field[2][2] == '.')) {
                                    Game.shootX2 = 2;
                                    Game.shootY2 = 2;
                                } else {
                                    if ((field[2][2] == 'X') && (field[2][0] == '.') && (field[2][1] == '.')) {
                                        Game.shootX2 = 2;
                                        Game.shootY2 = 1;
                                    } else {
                                        if ((field[2][0] != '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                            Game.shootX2 = 2;
                                            Game.shootY2 = 2;
                                        } else {
                                            if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                Game.shootX2 = 2;
                                                Game.shootY2 = 1;
                                            }  else {
                                                if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] != '.')) {
                                                    Game.shootX2 = 2;
                                                    Game.shootY2 = 0;
                                                } else {
                                                    if ((field[2][0] != '.') && (field[2][1] == '.') && (field[2][2] == '.')) {
                                                        Game.shootX2 = 2;
                                                        Game.shootY2 = 2;
                                                    } else {
                                                        if ((field[2][0] == '.') && (field[2][1] == '.') && (field[2][2] != '.')) {
                                                            Game.shootX2 = 2;
                                                            Game.shootY2 = 1;
                                                        } else {
                                                            if ((field[2][0] == '.') && (field[2][1] != '.') && (field[2][2] == '.')) {
                                                                Game.shootX2 = 2;
                                                                Game.shootY2 = 0;
                                                            } else {
                                                                if ((field[2][2] != '.') && (field[2][1] != '.') && (field[2][2] != '.')) {
                                                                    if ((field[1][0] != '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                                        if ((field[0][0] != '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                                                            Game.shootX2 = 0;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                                                Game.shootX2 = 0;
                                                                                Game.shootY2 = 1;
                                                                            } else {
                                                                                if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] != '.')) {
                                                                                    Game.shootX2 = 0;
                                                                                    Game.shootY2 = 0;
                                                                                } else {
                                                                                    if ((field[0][0] != '.') && (field[0][1] == '.') && (field[0][2] == '.')) {
                                                                                        Game.shootX2 = 0;
                                                                                        Game.shootY2 = 2;
                                                                                    } else {
                                                                                        if ((field[0][0] == '.') && (field[0][1] == '.') && (field[0][2] != '.')) {
                                                                                            Game.shootX2 = 0;
                                                                                            Game.shootY2 = 0;
                                                                                        } else {
                                                                                            if ((field[0][0] == '.') && (field[0][1] != '.') && (field[0][2] == '.')) {
                                                                                                Game.shootX2 = 0;
                                                                                                Game.shootY2 = 1;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        if ((field[1][0] != '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                                                            Game.shootX2 = 1;
                                                                            Game.shootY2 = 2;
                                                                        } else {
                                                                            if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] != '.')) {
                                                                                Game.shootX2 = 1;
                                                                                Game.shootY2 = 0;
                                                                            } else {
                                                                                if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                                                    Game.shootX2 = 1;
                                                                                    Game.shootY2 = 1;
                                                                                } else {
                                                                                    if ((field[1][0] != '.') && (field[1][1] == '.') && (field[1][2] == '.')) {
                                                                                        Game.shootX2 = 1;
                                                                                        Game.shootY2 = 0;
                                                                                    } else {
                                                                                        if ((field[1][0] == '.') && (field[1][1] == '.') && (field[1][2] != '.')) {
                                                                                            Game.shootX2 = 1;
                                                                                            Game.shootY2 = 1;
                                                                                        } else {
                                                                                            if ((field[1][0] == '.') && (field[1][1] != '.') && (field[1][2] == '.')) {
                                                                                                Game.shootX2 = 1;
                                                                                                Game.shootY2 = 2;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}
