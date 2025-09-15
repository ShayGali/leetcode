import numpy as np
class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        res = img
        img = np.array(img)
        for i in range(img.shape[0]):
            for j in range(img.shape[1]):

                res[i][j] = np.mean(img[i-1:i+1, j-1:j+1])

        return res