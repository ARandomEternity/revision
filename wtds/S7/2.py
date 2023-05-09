import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
import urllib.request
url = "http://archive.ics.uci.edu/ml/machine-learning-databases/00352/Online%20Retail.xlsx"
filename = "Online Retail.xlsx"
urllib.request.urlretrieve(url, filename)
df = pd.read_excel(filename)
print("Dataset information:")
print(df.info())
df = df.dropna()
df = df[df['Quantity'] > 0]
df['StockCode'] = pd.to_numeric(df['StockCode'], errors='coerce')
transactions = df.groupby(['InvoiceNo'])['StockCode'].apply(list).values.tolist()
te = TransactionEncoder()
te_ary = te.fit_transform(transactions)
tid = pd.DataFrame(te_ary, columns=te.columns_)
items = tid.astype('int')
min_sup = 0.03
frequent_itemsets = apriori(items, min_support=min_sup, use_colnames=True)
rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.7)
print('Min support:', min_sup)
print('Frequent itemsets:')
print(frequent_itemsets)
print('Association rules:')
print(rules)