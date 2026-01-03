package com.churkleung.ftc.camera;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.Optional;

public final class LimelightCamera {

    private final NetworkTable table;

    public LimelightCamera(String cameraId) {
        this.table = NetworkTableInstance.getDefault().getTable(cameraId);
    }

    /**
     * Attempts to get the currently visible AprilTag ID.
     *
     * @return Optional containing the tag ID if a target is visible, empty otherwise
     */
    public Optional<Integer> getVisibleAprilTagId() {
        double tv = table.getEntry("tv").getDouble(0);
        if (tv == 0) {
            return Optional.empty(); // No target visible
        }

        double tid = table.getEntry("tid").getDouble(-1);
        if (tid < 0) {
            return Optional.empty(); // Tag ID invalid or unreadable
        }

        return Optional.of((int) tid);
    }

    /**
     * Attempts to get the camera pose relative to the tag.
     *
     * @return Optional containing {X, Y, Z, Roll, Pitch, Yaw} if available
     */
    public Optional<double[]> getCameraPose() {
        double tv = table.getEntry("tv").getDouble(0);
        if (tv == 0) {
            return Optional.empty(); // No target
        }

        double[] pose = table.getEntry("camtran").getDoubleArray(new double[6]);
        if (pose.length != 6) {
            return Optional.empty(); // Malformed or missing data
        }

        return Optional.of(pose);
    }
}
