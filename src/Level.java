import java.util.*;

/**
 * Introduces the concept of a level to the game.
 * 
 */
public class Level {
        private ArrayList<LevelNode> levelNodes;

        public Level(ArrayList<LevelNode> levelNodes) {
                this.levelNodes = levelNodes;
                sortNodesByActivationDifficulty(this.levelNodes);
        }

        public Level() {

        }
        
        private void sortNodesByActivationDifficulty(ArrayList<LevelNode> nodes) {
                Collections.sort(nodes, new Comparator<LevelNode>() {
                                public int compare(LevelNode n1, LevelNode n2) {
                                        int a1 = n1.getActivationDifficulty();
                                        int a2 = n2.getActivationDifficulty();

                                        if(a1 == a2) {
                                                return 0;
                                        }
                                        if(a1 > a2) {
                                                return 1;
                                        }
                                        else {
                                                return -1;
                                        }
                                }
                        });
        }
        
        
        public void addSimpleNode(int activationDifficulty, ArrayList<EnemyEntity> spawnThese) {
                SimpleLevelNode sn =  new SimpleLevelNode(activationDifficulty, spawnThese);
                addNode(sn);
        }
        public void addNode(LevelNode l) {
                int i = 0;
                int diff = l.getActivationDifficulty();
                while(i < levelNodes.size() && diff <= levelNodes.get(i).getActivationDifficulty()) {
                        i++;
                }
                levelNodes.add(i, l);
        }
        /**
         * Returns when the next node wants to be activated.
         * Note that this assumes that the caller has manually checked (with hasNext())
         * that there is in fact a next node.
         */
        public int getNextDifficultyActivation() {
                return levelNodes.get(0).getActivationDifficulty();
        }
        /**
         * Is there another node?
         */
        public boolean hasNext() {
                return levelNodes.size() > 0;
        }

        /**
         * Activate the next node!
         */
        public ArrayList<EnemyEntity> activateNext() {
                LevelNode l = levelNodes.remove(0);
                return l.activate();
        }
}
