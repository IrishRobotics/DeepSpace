package frc.team2606.lib.geometry;

import frc.team2606.lib.util.CSVWritable;
import frc.team2606.lib.util.Interpolable;

//TODO figure out what is dependant on the State interface 

public interface State<S> extends Interpolable<S>, CSVWritable {
    double distance(final S other);

    boolean equals(final Object other);

    String toString();

    String toCSV();
}
