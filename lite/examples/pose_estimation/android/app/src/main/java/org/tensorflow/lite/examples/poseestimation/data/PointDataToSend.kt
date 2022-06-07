package org.tensorflow.lite.examples.poseestimation.data

import android.graphics.PointF

data class PointDataToSend(var bodyPart: Int, var xCoord: Float, var yCoord: Float)