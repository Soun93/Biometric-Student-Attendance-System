import numpy as np
import mediapipe as mp
from mediapipe.tasks import python
from mediapipe.tasks.python import vision
import cv2

# utilities
import visualization

MODEL_PATH = 'facial-recognition/models/blaze_face_short_range.tflite'
IMAGE_FILE = 'facial-recognition/Data/Jean/rotro_11.jpg'

# get image name
i = 0
for char in reversed(IMAGE_FILE):
    if char == '/':
        break
    i += 1

IMG_NAME = IMAGE_FILE[len(IMAGE_FILE) - i:len(IMAGE_FILE) - 4]

RESULT_PATH = 'facial-recognition/python/imgresults/'+IMG_NAME+'result.jpg'

print(RESULT_PATH)

# detector config

BaseOptions = mp.tasks.BaseOptions
FaceDetector = mp.tasks.vision.FaceDetector
FaceDetectorOptions = mp.tasks.vision.FaceDetectorOptions
VisionRunningMode = mp.tasks.vision.RunningMode

# create facedetector instance with mode IMAGE

options = FaceDetectorOptions(
    base_options=BaseOptions(model_asset_path=MODEL_PATH),
    running_mode=VisionRunningMode.IMAGE
)

with FaceDetector.create_from_options(options) as detector:
    # detector initialized
    image = mp.Image.create_from_file(IMAGE_FILE)

    result = detector.detect(image)

    image_copy = np.copy(image.numpy_view())
    annotated_image = visualization.visualize(image=image_copy, detection_result=result)
    rgb_annotated_image = cv2.cvtColor(annotated_image, cv2.COLOR_BGR2RGB)

    

    cv2.imwrite(RESULT_PATH, rgb_annotated_image)

