package org.example;

public class Player {

        private int x;
        private int y;
        private char symbol;
        private int previousX;
        private int previousY;

        public Player(int x, int y, char symbol) {
            this.x = x;
            this.y = y;
            this.previousX = x;
            this.previousY = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }


        public int getPreviousX() {
            return previousX;
        }

        public int getPreviousY() {
            return previousY;
        }


        public void moveLeft(){
            previousX = x;
            previousY = y;
            x -= 2;
        }

        public void moveRight(){
            previousX = x;
            previousY = y;
            x += 2;
        }

    }

