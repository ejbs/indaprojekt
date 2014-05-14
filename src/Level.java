/**
 * Introduces the concept of a level to the game.
 * 
 */
public class Level {
        ArrayList<LevelNode> levelNodes;

        public Level(ArrayList<LevelNode> levelNodes) {
                this.levelNodes = levelNodes;
                sortNodesByActivationDifficulty(this.levelNodes);
        }
        
        public void sortNodesByActivationDifficulty(ArrayList<LevelNode> nodes) {
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
                SimpleNode sn = SimpleNode(activationDifficulty, spawnThese);
                int i = 0;
                int diff = sn.getActivationDifficulty();
                while(i < levelNodes.size() && diff <= levelNodes.get(i).getActivationDifficulty()) {
                        i++;
                }
                levelNodes.add(i, sn);       
        }
}
