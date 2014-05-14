/**
 * This is the SimpleLevelNode.
 * Its activate() method simply retuurns the entities provided at construction-time
 * without doing anything else.
 */
public class SimpleLevelNode {
        private int final activationDifficulty;
        private ArrayList<EnemyEntity> entities;

        public SimpleLevelNode(int activationDifficulty, ArrayList<EnemyEntity> entities) {
                this.entities = entities;
                this.activationDifficulty = activationDifficulty;
        }

        public int getActivationDifficulty() {
                return activationDifficulty;
        }
        public ArrayList<EnemyEntity> activate() {
                return this.entities;
        }
}
