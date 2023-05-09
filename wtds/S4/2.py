import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
fish_data = pd.read_csv('fish_data.csv')
X = fish_data.iloc[:, 1:2].values
y = fish_data.iloc[:, 2].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
regressor = LinearRegression()
regressor.fit(X_train, y_train)
y_pred = regressor.predict(X_test)
from sklearn.metrics import mean_squared_error, r2_score
mse = mean_squared_error(y_test, y_pred)
r2 = r2_score(y_test, y_pred)
print("Mean squared error:", mse)
print("R2 score:", r2)
new_data = [[30]]
prediction = regressor.predict(new_data)
print("Predicted weight:", prediction)