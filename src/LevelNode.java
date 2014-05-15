import java.util.*;

/**
 * This is the LevelNode.
 * A LevelNode is something which is activated by a Level at some activationDifficulty.
 * Upon activation it returns some ArrayList of EnemyEntity:s.
 * Activation at the appropriate activationDifficulty is not enforced however it is expected.
 */
public interface LevelNode {

        /**
         * Returns the activationDifficulty of this LevelNode.
         * The activationDifficulty is an integer which says at
         * which difficulty a LevelNode should be activated.
         */
        public int getActivationDifficulty();
        
        /** 
         * activate() gives back a list of the enemies to be spawned.
         */
        public ArrayList<EnemyEntity> activate();
}
