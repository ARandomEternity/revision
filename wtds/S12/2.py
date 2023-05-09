import numpy as np
np.random.seed(0)
heights = np.random.normal(loc=170, scale=10, size=100)
weights = 0.7 * heights + np.random.normal(loc=0, scale=5, size=100)
data = np.column_stack((heights, weights))
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(data[:,0], data[:,1], test_size=0.2, random_state=0)
from sklearn.linear_model import LinearRegression
model = LinearRegression()
model.fit(X_train.reshape(-1, 1), y_train.reshape(-1, 1))
y_pred = model.predict(X_test.reshape(-1, 1))
from sklearn.metrics import r2_score
r2 = r2_score(y_test, y_pred)
print("R-squared:", r2)
