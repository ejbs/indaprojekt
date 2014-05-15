import java.util.*;

/**
 * Introduces the concept of a level to the game.
 * A Level is a container for LevelNodes,
 * with some book-keeping attached for spawning the entities in the right order.
 */
public class Level {
        private ArrayList<LevelNode> levelNodes;

        /**
         * Take an ArrayList of LevelNode:s and add them to the level.
         */
        public Level(ArrayList<LevelNode> levelNodes) {
                this.levelNodes = levelNodes;
                sortNodesByActivationDifficulty(this.levelNodes);
        }

        /**
         * Sorts all nodes by activationDifficulty.
         * Note that this is destructive.
         */
        private void sortNodesByActivationDifficulty(ArrayList<LevelNode> nodes) {
                Collections.sort(nodes, new Comparator<LevelNode>() {
                                public int compare(LevelNode n1, LevelNode n2) {
                                        int a1 = n1.getActivationDifficulty();
                                        int a2 = n2.getActivationDifficulty();

                                        if(a1 == a2) {
                                                return 0;
                                        }
                                        // A lower difficulty comes after a higher one
                                        if(a1 < a2) {
                                                return 1;
                                        }
                                        else {
                                                return -1;
                                        }
                                }
                        });
        }
        

        /**
         * Same as addNode() however it makes a SimpleLevelNode for you.
         * Often you only ever really need a SimpleLevelNode, this makes it
         * easier for the user to take care of that need.
         */
        public void addSimpleNode(int activationDifficulty, ArrayList<EnemyEntity> spawnThese) {
                SimpleLevelNode sn =  new SimpleLevelNode(activationDifficulty, spawnThese);
                addNode(sn);
        }
        
        /**
         * Add a LevelNode to the Level.
         * You should primarily not use this but instead use the constructor
         * which takes an ArrayList<LevelNode>.
         * This is mainly for altering a Level mid-play.
         */
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
         * If so, return true
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
