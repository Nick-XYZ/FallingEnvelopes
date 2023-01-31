package org.example;

public class MonsterEnvelope {
        private int x;
        private int y;
        private char monsterCharacter = '\u2709';


        public MonsterEnvelope(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

}
