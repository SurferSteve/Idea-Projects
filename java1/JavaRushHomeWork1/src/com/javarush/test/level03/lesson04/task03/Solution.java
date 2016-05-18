package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        Zerg zerg2 = new Zerg();
        Zerg zerg3 = new Zerg();
        Zerg zerg4 = new Zerg();
        Zerg zerg5 = new Zerg();
        Zerg zerg6 = new Zerg();
        Zerg zerg7 = new Zerg();
        Zerg zerg8 = new Zerg();
        Zerg zerg9 = new Zerg();
        Zerg zerg10 = new Zerg();

        zerg1.name = "муталиск";
        zerg2.name = "гидралиск";
        zerg3.name = "собака";
        zerg4.name = "таракан";
        zerg5.name = "оверлорд";
        zerg6.name = "улучшенный муталиск";
        zerg7.name = "королева";
        zerg8.name = "паук";
        zerg9.name = "стрекоза";
        zerg10.name = "скорпион";

        Protos zeratul = new Protos();
        zeratul.name = "Зератул";
        Protos drone = new Protos();
        drone.name = "Дрон";
        Protos observer = new Protos();
        observer.name = "Наблюдатель";
        Protos dragun = new Protos();
        dragun.name = "Драгун";
        Protos baton = new Protos();
        baton.name = "Батон";

        Terran terran1 = new Terran();
        Terran terran2 = new Terran();
        Terran terran3 = new Terran();
        Terran terran4 = new Terran();
        Terran terran5 = new Terran();
        Terran terran6 = new Terran();
        Terran terran7 = new Terran();
        Terran terran8 = new Terran();
        Terran terran9 = new Terran();
        Terran terran10 = new Terran();
        Terran terran11 = new Terran();
        Terran terran12 = new Terran();

        terran1.name = "Рабочий";
        terran2.name = "Морпех";
        terran3.name = "Танк";
        terran4.name = "Командир";
        terran5.name = "Невидимка";
        terran6.name = "Несущий ядерку";
        terran7.name = "машинка";
        terran8.name = "разжигатель";
        terran9.name = "стелс";
        terran10.name = "ворон";
        terran11.name = "крутой";
        terran12.name = "орун";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protos {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}