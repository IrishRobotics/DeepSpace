package frc.team2606.lib.geometry;

public interface ICurvature<S> extends State<S> {
    double getCurvature();

    double getDCurvatureDs();
}
