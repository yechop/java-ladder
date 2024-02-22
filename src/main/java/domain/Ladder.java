package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, Height height) {
        List<RowLine> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> rowLineGenerator.generate(height.getHeight()))
                .toList();
        return new Ladder(lines);
    }

    public Integer getHeight() {
        return lines.size();
    }

    public Integer getWidth() {
        return lines.get(0).getConnections().size();
    }
}