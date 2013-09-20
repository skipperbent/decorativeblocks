package pecee.decorativeblocks.block;

public class BlockProperties
{
    public static enum BlockType
    {
        WHITE(15, "White"),
        ORANGE(14, "Orange"),
        MAGENTA(13, "Magenta"),
        LBLUE(12, "Light Blue"),
        YELLOW(11, "Yellow"),
        LIME(10, "Lime"),
        PINK(9, "Pink"),
        GRAY(8, "Gray"),
        LGRAY(7, "Light Gray"),
        CYAN(6, "Cyan"),
        PURPLE(5, "Purple"),
        BLUE(4, "Blue"),
        BROWN(3, "Brown"),
        GREEN(2, "Green"),
        RED(1, "Red"),
        BLACK(0, "Black");

        private int code;
        private String name;

        private BlockType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public int getCode() {
            return this.code;
        }
    }
}
