import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
dataset = [['beer', 'chips', 'soda'],
           ['beer', 'soda', 'pizza', 'wings'],
           ['soda', 'pizza'],
           ['beer', 'chips', 'soda', 'pizza'],
           ['beer', 'chips', 'wings'],
           ['chips', 'soda', 'pizza']]
df = pd.DataFrame(dataset)
print("Dataset information:")
print(df.info())
te = TransactionEncoder()
te_ary = te.fit_transform(df.values)
tid = pd.DataFrame(te_ary, columns=te.columns_)
items = tid.astype('int')
min_sup = 0.5
frequent_itemsets = apriori(items, min_support=min_sup, use_colnames=True)
rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.5)
print('Min support:', min_sup)
print('Frequent itemsets:')
print(frequent_itemsets)
print('Association rules:')
print(rules)