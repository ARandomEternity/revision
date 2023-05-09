import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
df = pd.read_csv('Downloads/archive (3)/Groceries_dataset.csv')
print(df.info())
df.dropna(inplace=True)  # Drop rows with missing values
df = df.apply(lambda x: pd.factorize(x)[0])  # Convert categorical values to numeric format
te = TransactionEncoder()
te_ary = te.fit_transform(df.values)
df = pd.DataFrame(te_ary, columns=te.columns_)
frequent_itemsets = apriori(df, min_support=0.01, use_colnames=True)
association_rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.5)
print("Frequent Itemsets:")
print(frequent_itemsets)
print("Association Rules:")
print(association_rules)