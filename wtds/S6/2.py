import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
data = [['Milk', 'Egg', 'Bread'],
        ['Milk', 'Bread'],
        ['Milk', 'Egg', 'Bread', 'Cheese'],
        ['Milk', 'Egg'],
        ['Bread', 'Cheese']]
te = TransactionEncoder()
te_ary = te.fit_transform(data)
tid = pd.DataFrame(te_ary, columns=te.columns_)
items = tid.astype('int')
items = items.replace({True: 1, False: 0})
min_sup_values = [0.4, 0.6, 0.8]
for min_sup in min_sup_values:
    frequent_itemsets = apriori(items, min_support=min_sup, use_colnames=True)
    rules = association_rules(frequent_itemsets, metric="confidence", min_threshold=0.7)
    print('Min support:', min_sup)
    print('Frequent itemsets:')
    print(frequent_itemsets)
    print('Association rules:')
    print(rules)
    print()