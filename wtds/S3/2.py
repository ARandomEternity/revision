import pandas as pd
import numpy as np
user_data = {'User ID': [1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
             'Age': [19, 35, 26, 27, 19, 32, 25, 29, 34, 25],
             'Estimated Salary': [19000, 20000, 43000, 57000, 76000, 58000, 84000, 15000, 43000, 22000],
             'Purchased': [0, 0, 0, 0, 0, 1, 1, 0, 1, 0]}
user_df = pd.DataFrame(user_data)
X = user_df.iloc[:, 1:-1].values
y = user_df.iloc[:, -1].values
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=0)
from sklearn.linear_model import LogisticRegression
logistic_model = LogisticRegression()
logistic_model.fit(X_train, y_train)
y_pred = logistic_model.predict(X_test)
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score
print("Accuracy:", accuracy_score(y_test, y_pred))
print("Precision:", precision_score(y_test, y_pred))
print("Recall:", recall_score(y_test, y_pred))
print("F1-score:", f1_score(y_test, y_pred))