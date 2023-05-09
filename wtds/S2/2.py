import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
df = pd.DataFrame({
    'Position': ['Software Engineer', 'Product Manager', 'Data Scientist', 'Sales Executive', 'Marketing Manager', 'Intern'],
    'Level': [1, 2, 3, 4, 5, 6],
    'Salary': [5000, 8000, 11000, 15000, 20000, 25000]
})
X = df[['Level']]
y = df['Salary']
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)
lr = LinearRegression()
lr.fit(X_train, y_train)
print('Training set:')
print('X_train:', X_train)
print('y_train:', y_train)
print('Testing set:')
print('X_test:', X_test)
print('y_test:', y_test)