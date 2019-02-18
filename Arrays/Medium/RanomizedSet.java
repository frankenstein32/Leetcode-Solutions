class RandomizedSet {

    HashMap<Integer,Integer> data;
    ArrayList<Integer> elements;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
        this.data = new HashMap<>();
        this.elements = new ArrayList<>();

    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(this.data.containsKey(val)){
            return false;
        }else{

            this.data.put(val,this.elements.size());
            this.elements.add(val);
            return true;
        }
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(this.data.containsKey(val)){
            this.elements.remove(this.data.get(val));
            this.data.remove(val);
            return true;
        }
        return false;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {

        Random random = new Random();
        int idx = random.nextInt(this.elements.size());
        return this.elements.get(idx);
       
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */