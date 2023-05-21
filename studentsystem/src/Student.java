public class Student {
    private String id;
    private String name;
    private float mathscores;
    private float englishscores;
    private float computerscores;

    private float allscores;


    public Student() {
    }

    public Student(String id, String name, float mathscores, float englishscores, float computerscores, float allscores) {
        this.id = id;
        this.name = name;
        this.mathscores = mathscores;
        this.englishscores = englishscores;
        this.computerscores = computerscores;
        this.allscores = allscores;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return mathscores
     */
    public float getMathscores() {
        return mathscores;
    }

    /**
     * 设置
     * @param mathscores
     */
    public void setMathscores(float mathscores) {
        this.mathscores = mathscores;
    }

    /**
     * 获取
     * @return englishscores
     */
    public float getEnglishscores() {
        return englishscores;
    }

    /**
     * 设置
     * @param englishscores
     */
    public void setEnglishscores(float englishscores) {
        this.englishscores = englishscores;
    }

    /**
     * 获取
     * @return computerscores
     */
    public float getComputerscores() {
        return computerscores;
    }

    /**
     * 设置
     * @param computerscores
     */
    public void setComputerscores(float computerscores) {
        this.computerscores = computerscores;
    }

    /**
     * 获取
     * @return allscores
     */
    public float getAllscores() {
        return allscores;
    }

    /**
     * 设置
     * @param allscores
     */
    public void setAllscores(float allscores) {
        this.allscores = allscores;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", mathscores = " + mathscores + ", englishscores = " + englishscores + ", computerscores = " + computerscores + ", allscores = " + allscores + "}";
    }
}
