import pandas as pd
from mlxtend.preprocessing import TransactionEncoder
from mlxtend.frequent_patterns import apriori, association_rules
transactions = [['eggs','milk','bread'],
                ['eggs','apple'],
                ['milk','bread'],
                ['apple','milk'],
                ['milk','apple','bread']]
te = TransactionEncoder()
te_array = te.fit(transactions).transform(transactions)
df = pd.DataFrame(te_array, columns=te.columns_)
frequent_itemsets = apriori(df, min_support=0.4, use_colnames=True)
rules = association_rules(frequent_itemsets, metric='lift', min_threshold=1)
print("Frequent Itemsets:\n", frequent_itemsets)
print("\nAssociation Rules:\n", rules)