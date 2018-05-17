import numpy
import pandas as pd
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeRegressor
from sklearn.model_selection import cross_val_score
reg = DecisionTreeRegressor(max_depth=11)
dt = pd.read_csv("Agm_new.csv")
data = pd.get_dummies(dt)
Y_true = numpy.array(data['Modal Price (Rs./Quintal)'])
X_true = data.drop('Modal Price (Rs./Quintal)',axis=1)
X_train,X_test,Y_train,Y_test = train_test_split(X_true,Y_true,test_size=0.25,random_state=42)
#score = cross_val_score(reg,X_true,Y_true,cv=10)
#print(score)
reg.fit(X_train,Y_train)
pred = reg.predict(X_test)
error = abs(pred - Y_test)
quil = 100*(numpy.sum(error)/numpy.sum(Y_test))
accuracy = 100 - numpy.mean(quil)
#print(accuracy,"%")
f = open('Accuracy.csv','a')
f.write(str(accuracy)+',')
f.close()