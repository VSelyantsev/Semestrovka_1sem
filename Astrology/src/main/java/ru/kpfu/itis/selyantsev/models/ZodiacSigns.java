package ru.kpfu.itis.selyantsev.models;

public class ZodiacSigns {

    private Long zodiacId;
    private String zodiacName;
    private String zodiacType;
    private String zodiacElement;

    public ZodiacSigns(Long zodiacId, String zodiacName, String zodiacType, String zodiacElement) {
        this.zodiacId = zodiacId;
        this.zodiacName = zodiacName;
        this.zodiacType = zodiacType;
        this.zodiacElement = zodiacElement;
    }

    public ZodiacSigns(String zodiacName, String zodiacType, String zodiacElement) {
        this.zodiacName = zodiacName;
        this.zodiacType = zodiacType;
        this.zodiacElement = zodiacElement;
    }

    public Long getZodiacId() {
        return zodiacId;
    }

    public void setZodiacId(Long zodiacId) {
        this.zodiacId = zodiacId;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public void setZodiacName(String zodiacName) {
        this.zodiacName = zodiacName;
    }

    public String getZodiacType() {
        return zodiacType;
    }

    public void setZodiacType(String zodiacType) {
        this.zodiacType = zodiacType;
    }

    public String getZodiacElement() {
        return zodiacElement;
    }

    public void setZodiacElement(String zodiacElement) {
        this.zodiacElement = zodiacElement;
    }
}
